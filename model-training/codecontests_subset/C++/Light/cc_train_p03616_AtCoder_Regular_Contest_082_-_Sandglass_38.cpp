#include <bits/stdc++.h>

using namespace std;

int r[100001];

int main(){
    #ifdef DEBUG
    freopen("input.txt", "r", stdin);
    #endif
    ios_base::sync_with_stdio(0), cin.tie(0);
    int x, k;
    cin >> x >> k;
    for (int i = 1; i <= k; i++){
        cin >> r[i];
    }
    int q;
    cin >> q;
    int j = 0;
    int d = 0;
    int mn = 0;
    int mx = x;
    int valmn = 0;
    int valmx = x;
    for (int i = 0; i < q; i++){
        int t1, a1;
        cin >> t1 >> a1;
        while (j + 1 <= k && t1 >= r[j + 1]){
            int ch = r[j + 1] - r[j];
            if (j & 1){
                mx = min(mx, mx + (x - valmx - ch));
                valmn = min(valmn + ch, x);
                valmx = min(valmx + ch, x);
            } else {
                mn = max(mn, mn + ch - valmn);
                valmn = max(valmn - ch, 0);
                valmx = max(valmx - ch, 0);
            }
            j++;
        }
        int ans;
        if (a1 <= mn){
            ans = valmn;
        } else if (a1 >= mx){
            ans = valmx;
        } else {
            ans = valmn + (a1 - mn);
        }
        if (j & 1) {
            ans = min(ans + (t1 - r[j]), x);
        } else {
            ans = max(ans - (t1 - r[j]), 0);
        }
        cout << ans << "\n";
    }
    return 0;
}

