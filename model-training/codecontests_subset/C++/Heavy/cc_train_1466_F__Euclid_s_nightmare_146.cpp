// codeforce
// wangqc
#include<iostream>
#include<vector>

using namespace std;

const int M = 1e9+7;

vector<int> p, rk, ans;

int find(int x)
{
    return x == p[x] ? x : p[x]=find(p[x]);
}

int connect(int x, int y)
{
    int px = find(x), py = find(y);
    if(px == py) return false;
    if(rk[px] < rk[py]) swap(px, py);
    if(rk[px] == rk[py]) rk[px]++;
    p[py] = px;
    return true;
}

int main()
{
    int n, m;
    cin >> n >> m;
    p.resize(m+2), rk.resize(m+2), ans.clear();
    for(int i = 0; i <= m; i++)
        p[i] = i, rk[i] = 0;
    int k, x, y;
    for(int i = 1; i <= n; i++)
    {
        cin >> k >> x;
        if(k == 1) y = m+1;
        else cin >> y;
        if(connect(x, y)) ans.push_back(i);
    }
    n = ans.size(), m = 1;
    for(int _ = 0; _ < n; _++) m = (m<<1) % M;
    cout << m << " " << n << endl;
    for(int i : ans) cout << i << " ";
    cout << endl;
    return 0;
}
