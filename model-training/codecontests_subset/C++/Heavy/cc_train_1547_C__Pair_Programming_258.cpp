#include <bits/stdc++.h>

using namespace std;

const int inf = 987654321;
const int MX = 105;

int t, k, n, m, a[MX], b[MX];
vector <int> ans;

int main(){
    cin.tie(nullptr), ios::sync_with_stdio(false);
    cin >> t;
    while(t--){
        cin >> k >> n >> m;
        for(int i = 0; i < n; i++) cin >> a[i];
        for(int i = 0; i < m; i++) cin >> b[i];
        int p1 = 0, p2 = 0;
        a[n] = b[m] = inf;
        ans.clear();
        while(a[p1] <= k || b[p2] <= k){
            if(a[p1] <= k){
                ans.push_back(a[p1]);
                if(a[p1] == 0) k++;
                p1++;
            }else{
                ans.push_back(b[p2]);
                if(b[p2] == 0) k++;
                p2++;
            }
        }
        if((int)ans.size() == n + m){
            for(int i : ans) cout << i << " ";
            cout << "\n";
        }else cout << "-1\n";
    }

}
