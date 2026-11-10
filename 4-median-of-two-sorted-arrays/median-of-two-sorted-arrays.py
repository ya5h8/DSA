class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        
        # Always perform binary search on the smaller array
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        m = len(nums1)
        n = len(nums2)

        low = 0
        high = m

        while low <= high:

            partitionX = (low + high) // 2
            partitionY = (m + n + 1) // 2 - partitionX

            # Left and right values of both arrays
            maxLeftX = float('-inf') if partitionX == 0 else nums1[partitionX - 1]
            minRightX = float('inf') if partitionX == m else nums1[partitionX]

            maxLeftY = float('-inf') if partitionY == 0 else nums2[partitionY - 1]
            minRightY = float('inf') if partitionY == n else nums2[partitionY]

            # Correct partition found
            if maxLeftX <= minRightY and maxLeftY <= minRightX:

                # Odd number of elements
                if (m + n) % 2 == 1:
                    return float(max(maxLeftX, maxLeftY))

                # Even number of elements
                return (max(maxLeftX, maxLeftY) +
                        min(minRightX, minRightY)) / 2.0

            # Move binary search to the left
            elif maxLeftX > minRightY:
                high = partitionX - 1

            # Move binary search to the right
            else:
                low = partitionX + 1

        return 0.0
