def segregate(nums):
    left = 0
    right = len(nums) - 1
    i = 0

    while i <= right:
        if nums[i] == 0:
            swap(nums, i, left)
            left += 1
            i += 1
        else:
            swap(nums, i, right)
            right -= 1
    
def swap(nums, i, j):
    nums[i] = nums[i] ^ nums[j]
    nums[j] = nums[i] ^ nums[j]
    nums[i] = nums[i] ^ nums[j]


arr = list(map(int, input().split(",")))
segregate(arr)
print(arr)