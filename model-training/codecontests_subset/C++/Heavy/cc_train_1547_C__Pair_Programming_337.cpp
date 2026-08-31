#include <iostream>
#include <vector>
using namespace std;
int t,k,n,m;
vector<int> a,b,v;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin>>t;
    while (t--) {
        cin>>k>>n>>m;
        a.resize(n);
        b.resize(m);
        for (int &x:a) cin>>x;
        for (int &x:b) cin>>x;
        auto solve=[&]()->vector<int> {
            vector<int> sequences;
            int l=0,r=0,cur=k;
            while (true) {
                if (l==n && r==m) break;
                if (l!=n && a[l]>=0 && a[l]<=cur) {
                    if (a[l]==0) cur++;
                    sequences.emplace_back(a[l++]);
                }
                else if (r!=m && b[r]>=0 && b[r]<=cur) {
                    if (b[r]==0) cur++;
                    sequences.emplace_back(b[r++]);
                }
                else return vector<int> {-1};
            }
            return sequences;
        };
        v=solve();
        for (int i=0;i<(int)v.size();i++) cout<<v[i]<<" \n"[i==(int)v.size()-1];
    }
}