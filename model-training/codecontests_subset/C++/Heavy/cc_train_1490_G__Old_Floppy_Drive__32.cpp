#include<bits/stdc++.h>

using namespace std;

#define endl "\n"
#define lln long long int
#define ld long double
#define all(x) (x).begin(),(x).end()
#define IOS ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
const int MOD = 1e9 + 7;


int main(){
    IOS;
    
    int a1;
    cin >> a1;
    for(int TT=0;TT<a1;TT++){
        int n, m;
        cin >> n >> m;
        vector<int> A(n);
        vector<pair<lln,int>> pref;
        for(int i=0;i<n;i++) cin >> A[i];
        pref.push_back({A[0], 0});
        lln ma = A[0], sum = A[0];
        for(int i=1;i<n;i++){
            sum += A[i];
            if(sum > pref.back().first) pref.push_back({sum, i});
            ma = max(ma, pref.back().first);
        }
        for(int i=0;i<m;i++){
            int q;
            cin >> q;
            if(q <= A[0]){
                cout << 0 << " ";
                continue;
            }
            if(q > ma && sum <= 0){
                cout << -1 << " ";
                continue;
            }
            lln cal = 0, ans = 0;
            if(ma < q){
                ans = ((q - ma) / sum );
                if((q - ma) % sum) ans ++;
                q = q - ans * sum;
                ans = ans * n;
            }
            int l = 0, r = pref.size() - 1;
            while(q > 0 && l <= r){
                int m = (l + r) / 2;
                if(pref[m].first >= q){
                    cal = m;
                    r = m - 1;
                }
                else l = m + 1;
            }
            cout << ans + pref[cal].second << " "; 
        }
        cout << endl;
    }
    return 0;    
}