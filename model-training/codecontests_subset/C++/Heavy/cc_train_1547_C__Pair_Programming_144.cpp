#include <bits/stdc++.h>
using namespace std;
#define ar array
#define int long long
#define all(x) (x).begin(), (x).end()
const int MAX_N = 1e5 + 1;
const int MOD = 1e9 + 7;
const int INF = 1e9;
const int LINF = 1e18;
void solve() {

int tc = 1;
cin >> tc;
for (int t = 1; t <= tc; t++) {
   int l,n,m;
   cin>>l>>n>>m;
   int arr[n],brr[m];
   for(int i=0;i<n;i++)
     cin>>arr[i];
     for(int j=0;j<m;j++)
      cin>>brr[j];
    int cl=0;
    int ans[n+m];
    int ptr1=0,ptr2=0;
    bool yes=true;
    memset(ans,-1,sizeof(ans));
    for(int i=0;i<n+m;i++)
    {
        if(ptr1<n&&arr[ptr1]==0){
            ans[i]=arr[ptr1];
            ptr1++;
            l++;
            continue;
        }
        if(ptr2<m&&brr[ptr2]==0){
            ans[i]=brr[ptr2];
            l++;
            ptr2++;
            continue;
        }
         if(ptr1<n&&arr[ptr1]<=l){
             ans[i]=arr[ptr1];
             ptr1++;
             continue;

         }
         if(ptr2<m&&brr[ptr2]<=l){
             ans[i]=brr[ptr2];
             ptr2++;
             continue;
         }
         yes=false;
         break;
        
        
    }
    if(yes){
         for(auto i:ans) cout<<i<<" ";
    }
    else{
   cout<<-1<<" ";
    }
    cout<<endl;

}
 
}
 
signed main() {
ios_base::sync_with_stdio(0);
cin.tie(0); cout.tie(0);
solve();
}