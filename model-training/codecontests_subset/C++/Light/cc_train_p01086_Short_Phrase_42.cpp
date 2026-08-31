#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int solve(vector<int> &a) {
    int n = a.size();
    for (int i = 0; i < n; i++) {
        int cur = i;
        bool ok = true;
        for (int tgt: {5, 7, 5, 7, 7}) {
            int cnt = 0;
            while (cur < n && cnt + a[cur] <= tgt) cnt += a[cur++];
            if (cnt != tgt) { ok = false; break; }
        }
        if (ok) return i;
    }
    return -1;
}

int main() {
    int n;
    while (cin >> n, n) {
        vector<int> len(n);
        for (int i = 0; i < n; i++) {
            string s; cin >> s;
            len[i] = s.size();
        }
        cout << solve(len) + 1 << endl;
    }
    return 0;
}

