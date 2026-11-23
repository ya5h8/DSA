class Solution(object):
    def findDisappearedNumbers(self, nums):
        count = {}
        for i in nums:
            if i in count:
                count[i] += 1
            else:
                count[i] = 1
        missing = []

        for i in range(1, len(nums)+1):
            if i not in count:
                missing.append(i)
        return missing        