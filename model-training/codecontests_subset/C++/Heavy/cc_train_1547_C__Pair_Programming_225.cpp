#include <bits/stdc++.h>
#define int long long
using namespace std;
signed main(){
    int t;
    cin >> t;
    while(t--){
        int k, n, m;
        cin >> k >> n >> m;
        int a[n + 1], b[m + 1];
        for(int i = 0;i < n;i++){
            cin >> a[i];
        }
        for(int i = 0;i < m;i++){
            cin >> b[i];
        }
        a[n] = 0x3f3f3f3f, b[m] = 0x3f3f3f3f;
        vector<int> ans; //答案序列
        int l = k, ai = 0, bi = 0; //ai，bi分别表示两个数组分别删到了哪里，l为行数
        bool flag = false;
        while(ans.size() < n + m){
            if(a[ai] == 0){
                ai++, ans.push_back(0);
                l++;
                continue;
            }
            else if(b[bi] == 0){
                bi++, ans.push_back(0);
                l++;
                continue;
            }
            int p = min(a[ai], b[bi]);
            if(p == a[ai]){
                ai++;
            }
            else{
                bi++;
            }
            if(p > l){
                flag = true;
                break;
            }
            ans.push_back(p);
        }
        if(flag){
            cout << -1 << endl;
        }
        else{
            for(int i = 0;i < ans.size();i++){
                cout << ans[i] << " "; //输出答案序列
            }
            cout << endl;
        }
    }
    return 0;
}