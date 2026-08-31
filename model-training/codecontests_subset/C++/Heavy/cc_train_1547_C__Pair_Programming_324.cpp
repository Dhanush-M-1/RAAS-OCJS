#include<iostream>
#include<algorithm>
#include<cstdio>
#include<cstdlib>
#include<cmath>
#include<cstring>
#include<string>
#include<queue>
#include<stack>
#include<vector>
#include<map>
#include<set>
#include<iomanip>
#include<sstream>
#define int long long
#define ll long long
// inline int read(){int x=0,f=1;char ch=getchar();while(ch<'0'||ch>'9'){if(ch=='-')f=-1;ch=getchar();}
// while(ch>='0'&&ch<='9'){x=(x<<1)+(x<<3)+(ch^48);ch=getchar();}return x*f;}
const double eps = 1e-8;
const double PI = acos(-1.0);
const int N = 2e5 + 50;
const int M = 1e9 + 10;
const int inf = 0x3f3f3f3f;
const ll INF = 0x7fffffffffffffffll;
 
using namespace std;

int n, m, k;
int T, q;

signed main()
{
    ios::sync_with_stdio(false);
    cin >> T;
    while(T--){
        cin >> k >> n >> m;
        vector<int> a, b;
        for (int i = 0; i < n;i++){
            cin >> q;
            a.push_back(q);
        }
        for (int i = 0; i < m;i++){
            cin >> q;
            b.push_back(q);
        }
        vector<int> ans;
        int f = 1, l1 = 0, l2 = 0;
        a.push_back(inf);
        b.push_back(inf);
        while(l1<n||l2<m){
            // cout << l1 << " " << l2 << endl;
            if(a[l1]<=b[l2]){
                if(a[l1]==0){
                    k++;
                    l1++;
                    ans.push_back(0);
                }else{
                    if(a[l1]<=k){
                        ans.push_back(a[l1]);
                        l1++;
                    }else{
                        f = 0;
                        break;
                    }
                }
            }else{
                if(b[l2]==0){
                    k++;
                    l2++;
                    ans.push_back(0);
                }else{
                    if(b[l2]<=k){
                        ans.push_back(b[l2]);
                        l2++;
                    }else{
                        f = 0;
                        break;
                    }
                }
            }
        }
        if(f){
            for(auto x:ans){
                cout << x << " ";
            }
            cout << "\n";
        }else{
            cout<<"-1"<<"\n";
        }
    }
    
    return 0;
}
