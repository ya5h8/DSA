class Solution(object):
    def intersection(self, nums1, nums2):
        result = [] 
        for num in nums1:
            if num in nums2 and num not in result:
                result.append(num)

        return result

        