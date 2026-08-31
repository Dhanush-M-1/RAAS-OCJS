#include <bits/stdc++.h>
#define l long
#define ll long long 
#define pb push_back 
#define vi vector<int>
#define pi pair<int, int>
#define M pow(10,9)+7
#define endl "\n"
#define rep(i,a,n) for(int i = a;i<n;i++)
#define REP(i,k,n) for (int i = k; i <= n; ++i) 
#define repr(i,k,n) for (int i = k; i >= n; --i)
#define each(i,v) for(auto i:v)

using namespace std;

void solve(){
    int k,n,m;
    cin >> k >> n >> m;
    int a[n],b[m],ans[n+m];

    rep(i,0,n) cin >> a[i];
    rep(i,0,m) cin >> b[i];

    int i=0,j=0,p=0;
    bool f=true;
    while(i<n && j<m){
        if(a[i] > k && b[j] > k){
            f=false;break;
        }
        if(a[i]==0 || b[j]==0){
            if(a[i]==0)
            {
                ans[p++]=a[i];
                i++;
            }
            else{
                ans[p++]=b[j];
                j++;    
            }
            k++;
        }
        
        else if(a[i] <= k){
            ans[p++]=a[i];
            i++;
        }
        else if(b[j] <= k){
            ans[p++]=b[j];
            j++;
        }
    }
    if(f){
    while(i<n){
        if(a[i]==0){
            ans[p++]=0;
            i++;
            k++;
        }
        else if(a[i] <= k){
            ans[p++]=a[i];
            i++;
        }
        else {
            f=false;break;
        }
    }
    while(j<m){
        if(b[j]==0){
            ans[p++]=0;
            j++;
            k++;
        }
        else if(b[j] <= k){
            ans[p++]=b[j];
            j++;
        }
        else {
            f=false;break;
        }
    }
    }
    if(!f){
        cout << -1;return;
    }

    rep(i,0,n+m){
        cout << ans[i] << " ";
    }
}
int main()
{
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    while(t--){
        solve();
        cout << endl;
    }
    cerr << "time taken : " << (float)clock() / CLOCKS_PER_SEC << " secs" << "\n";
    return 0;
}