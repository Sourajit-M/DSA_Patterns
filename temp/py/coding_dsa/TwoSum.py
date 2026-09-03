def twoSum(nums, target):
    map = {}
    ans = []

    for i in range(0, len(nums)):
        num = nums[i]
        diff = target - num

        if diff in map:
            ans.append([map[diff], i])
        map[num] = i
    
    return ans

nums = list(map(int, input().split()))
target = int(input("target = "))

print(twoSum(nums, target))
# [2,7,11,15] 9