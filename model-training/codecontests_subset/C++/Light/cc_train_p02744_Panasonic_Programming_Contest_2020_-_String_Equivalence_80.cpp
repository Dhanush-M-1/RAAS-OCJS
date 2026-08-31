#include <bits/stdc++.h>

using namespace std;

void solve(string s, char v, int n) {
    if (n == 0) {
        cout << s << endl;
        return;
    }
    for (char c = 'a'; c <= v; c++) {
        solve(s + c, c < v ? v : v + 1, n - 1);
    }
}

int main(void) {
    int n;
    cin >> n;

    solve("", 'a', n);

    return 0;
}
