#include <bits/stdc++.h>

using namespace std;

int solve(int N, int cnt) {
    if (N < 10) return cnt;
    cnt++;
    if (cnt == 10000000) return -1;
    int syou, amari;
    int mn = -1;
    for (int i = 10; i < 10000000; i *= 10) {
        syou = N / i;
        if (!syou) break;
        amari = N % i;
        mn    = max(mn, syou * amari);
    }
    cnt = solve(mn, cnt);
    return cnt;
}

int main() {
    int Q;
    cin >> Q;
    int N;
    vector<int> ans;
    for (int i = 0; i < Q; i++) {
        cin >> N;
        int cnt = 0;
        ans.push_back(solve(N, cnt));
    }
    for (int i : ans) cout << i << endl;
}
