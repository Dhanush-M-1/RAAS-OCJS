def main():
    def finding_frist_occurrence(l, target, s, e, result = None):
        if s > e:
            return result
        mid = (s + e)//2
        if target < l[mid]:
            return finding_frist_occurrence(l, target, s, mid - 1, result)
        elif target == l[mid]:
            return finding_frist_occurrence(l, target, s, mid - 1, mid)
        else:
            return finding_frist_occurrence(l, target, mid + 1, e, result)

    def finding_last_occurrence(l, target, s, e, result = None):
        if s > e:
            return result
        mid = (s + e) // 2
        if target > l[mid]:
            return finding_last_occurrence(l, target, mid + 1, e, result)
        elif target == l[mid]:
            return finding_last_occurrence(l, target, mid + 1, e, mid)
        else:
            return finding_last_occurrence(l, target, s, mid - 1, result)

    def count_accurrence(l, target):
        start = finding_frist_occurrence(l, target, 0, len(l) -1)
        if start is not None:
            end = finding_last_occurrence(l, target, 0, len(l) - 1)
            return end - start + 1
        return 0

    nteams = int(input())
    home_uniforms = []
    guest_uniforms = []
    for i in range(nteams):
        t = tuple(map(int, input().split()))
        home_uniforms.append(t[0])
        guest_uniforms.append(t[1])

    def games(home_uniforms, guest_uniforms):
        guest_uniforms.sort()
        counter = 0
        for home_uniform in home_uniforms:
            counter += count_accurrence(guest_uniforms, home_uniform)
        return counter

    print(games(home_uniforms, guest_uniforms))
if __name__ == "__main__":
    main()