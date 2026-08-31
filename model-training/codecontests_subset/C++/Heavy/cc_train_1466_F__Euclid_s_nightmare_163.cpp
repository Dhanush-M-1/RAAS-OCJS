#include <bits/stdc++.h>

#define MOD 1000000007
#define all(x) x.begin(), x.end()

using namespace std;

typedef long long ll;
typedef vector<ll> dlist;
typedef vector<dlist> matrix;

struct DS{
    vector<bool> uni;
    vector<int> p, c;
    DS(int n): p(n, 0), c(n, 1), uni(n, false){
        for(int i = 0; i < n; ++i)
            p[i] = i;
    }
    int SetOf(int x){
        return (p[x] == x)? x : p[x] = SetOf(p[x]);
    }
    bool Merge(int x, int y){
        x = SetOf(x);
        y = SetOf(y);
        if((x == y) || (uni[x] && uni[y]))
            return false;
        if(c[x] < c[y])
            swap(x, y);
        p[y] = x;
        c[x] += c[y];
        uni[x] = (uni[x] | uni[y]);
        return true;
    }
};

void solve(){
    int n, m;
    cin >> n >> m;
    matrix data(n);
    DS ds(m + 1);
    vector<int> sel;
    for(int i = 0; i < data.size(); ++i){
        auto &x = data[i];
        int v; cin >> v;
        for(int j = 0; j < v; ++j){
            int k; cin >> k;
            x.push_back(k);
        }
        if(v == 1){
            v = ds.SetOf(x[0]);
            if(ds.uni[v]) continue;
            ds.uni[v] = true;
        }
        else if(!ds.Merge(x[0], x[1]))
            continue;
        sel.push_back(i);
    }

    int cant = 0;
    for(int i = 1; i <= m; ++i){
        int v = ds.SetOf(i);
        cant += (ds.c[v] - !ds.uni[v]) * (v == i);
    }
    ll ans = 1;
    for(int i = 1; i <= cant; ++i)
        ans = (ans * 2) % MOD;
     
    cout << ans << " " << cant << "\n"; 
    for(auto &x:sel)
        cout << x + 1 << " \n"[&x == &sel.back()];   
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t = 1;
    while(t--) solve();

    return 0;
}//RUL0
