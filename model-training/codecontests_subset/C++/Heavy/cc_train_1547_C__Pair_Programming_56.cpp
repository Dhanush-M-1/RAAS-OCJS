#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int MX = 2e3+5;
#define ll long long 
 


int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif
   
     int t;
     cin>>t;
     while(t--)
     { 
        int k,n,m;
        cin>>k>>n>>m;
        int a[n],b[m];
        for(int i=0;i<n;i++)
            cin>>a[i];
        for(int i=0;i<m;i++)
            cin>>b[i];
      int i=0,j=0;
      vector<int>ans;
      while(i<n&&j<m)
      {
          if(a[i]<b[j])
            ans.push_back(a[i++]);
        else
            ans.push_back(b[j++]);

      }
      while(i<n)ans.push_back(a[i++]);
      while(j<m)ans.push_back(b[j++]);

      bool flag=0;
      for(int i=0;i<ans.size();i++)
      {
        if(ans[i]==0)k++;
        else if(ans[i]>k)
            flag=1;
      }
      if(flag)
        cout<<-1;
     else
     {
        for(int i=0;i<ans.size();i++)
            cout<<ans[i]<<" ";
     }
     cout<<"\n";

        
     }
}

