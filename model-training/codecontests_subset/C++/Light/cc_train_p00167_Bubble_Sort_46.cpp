#include <bits/stdc++.h>
using namespace std;
#define rep(i, n) for (int i = 0; i < (n); i++)
typedef long long ll;
typedef pair<int, int> P;

vector<int> ans;

void solve(int n) {
    vector<int> a(n);
    rep(i, n) cin >> a[i];

    int res = 0;
    for (int i = n-1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (a[j] > a[j+1]) {
                swap(a[j], a[j+1]);
                res++;
            }
        }
    }
    ans.push_back(res);
    return ;
}

int main() {
    while (true) {
        int n;
        cin >> n;
        if (n == 0) break;
        solve(n);
    }

    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << endl;
    }

    return 0;
}
