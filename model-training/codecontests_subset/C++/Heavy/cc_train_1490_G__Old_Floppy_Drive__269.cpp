/*
    Author: Manish Kumar
    Username: manicodebits
   created: 23:43:03 16-02-2021
*/


#include <bits/stdc++.h>
using namespace std;
#define int long long
#define PI 3.141592653589
#define MOD 1000000007
#define FAST_IO ios_base::sync_with_stdio(false), cin.tie(0)
#define deb(x) cout<<"[ "<<#x<<" = "<<x<<"] " 


void solve(){ 
    int n,m;cin>>n>>m;
    vector<int> arr(n);
    for(int i=0;i<n;i++)
    cin>>arr[i];
    int sum=0;
    int prev=-1;
    int mx=INT_MIN;
    vector<int> prefix,prefix_index;
    for(int i=0;i<n;i++)
    {
        sum+=arr[i];
        if(sum>prev)
        {
          prev=sum;
          prefix.push_back(sum);
          prefix_index.push_back(i);
        }
        mx=max(mx,sum);
    }
    
    while(m--)
    {
        int x;cin>>x;
        if(x>mx && sum<=0)
        cout<<"-1 ";
        else{
           
                int cnt=0;
                if(x>mx)
                {
                    int round=(x-mx+(sum-1))/sum;
                    x-=round*sum;
                    cnt+=(n)*round;
                }
                int lowerBound=lower_bound(prefix.begin(),prefix.end(),x)-prefix.begin();
                cout<<cnt+prefix_index[lowerBound]<<" ";

        }

    }
    cout<<"\n";
}


signed main(){
FAST_IO;
int t=1;
cin>>t;
while(t--)
solve();
return 0;
}
