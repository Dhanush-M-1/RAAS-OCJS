#include<bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
using pint = pair<int, int>;
using pll = pair<ll, ll>;

int main(){
    int t; cin >> t;
    while(t--){
        int k, n, m; cin >> k >> n >> m;
        queue<int> a, b;
        int size = k;
        for(int i = 0; i < n; i++){
            int x; cin >> x;
            a.push(x);
        }
        for(int j = 0; j < m; j++){
            int x; cin >> x;
            b.push(x);
        }
        bool ok = true;
        vector<int> ans;
        while(!a.empty() && !b.empty()){
            int op;
            if(a.front() < b.front()){
                op = a.front();
                a.pop();
            }
            else{
                op = b.front();
                b.pop();
            }
            if(op == 0)size++;
            else{
                if(op > size){
                    ok = false;
                    break;
                }
            }
            ans.push_back(op);
        }
        if(ok){
            int op;
            while(!a.empty()){
                op = a.front();
                a.pop();
                if(op == 0)size++;
                else{
                    if(op > size){
                        ok = false;
                        break;
                    }
                }
                ans.push_back(op);
            }
            while(!b.empty()){
                op = b.front();
                b.pop();
                if(op == 0)size++;
                else{
                    if(op > size){
                        ok = false;
                        break;
                    }
                }
                ans.push_back(op);
            }
        }
        if(ok){
            for(int i = 0; i < ans.size(); i++)cout << ans[i] << " ";
            cout << endl;
        }
        else{
            cout << -1 << endl;
        }
    }
}