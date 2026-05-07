#space O(n)
#time n*log(n)

def merge_sort(arr, start, end):
    if start >= end:
        return

    mid = start + (end - start) // 2
    merge_sort(arr, start, mid)
    merge_sort(arr, mid + 1, end)

    merge(arr, start, mid, end)


def merge(arr, start, mid, end):
    n1 = mid - start + 1
    n2 = end - mid
    # [5, 2, 4, 3, 1, 8, 7, 6]
    left = arr[start : mid + 1]
    right = arr[mid + 1 : end + 1]

    temp = []
    left_itr = 0
    right_itr = 0

    # compare both arrays
    while left_itr < n1 and right_itr < n2:
        if left[left_itr] <= right[right_itr]:
            temp.append(left[left_itr])
            left_itr += 1
        else:
            temp.append(right[right_itr])
            right_itr += 1

    #if any left on left array
    while left_itr < n1:
        temp.append(left[left_itr])
        left_itr += 1
    #if any left on right array
    while right_itr < n2:
        temp.append(right[right_itr])
        right_itr += 1

    arr[start : end + 1] = temp #adding in original array


arr = [5, 2, 4, 3, 1, 8, 7, 6]
merge_sort(arr, 0, len(arr) - 1)
print(arr)
