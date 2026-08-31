#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define mod 1000000007
#define endl "\n"



void solve(){
   int k,a,b;cin>>k>>a>>b;
  
   vector<int> a1(a),a2(b);
   vector<int>res; 
   for(int i=0;i<a;i++) cin>>a1[i];
   for(int i=0;i<b;i++) cin>>a2[i];
   
   int i=0,j=0;
   while(i<a and j<b){
     if(a1[i]==0){
       res.push_back(0);
       i++;
       k++;
     }
    else if(a2[j]==0){
       res.push_back(0);
       j++;
       k++;
     }
     else {
        if(a1[i]<a2[j]){
          if(a1[i]<=k){
            res.push_back(a1[i]);
            i++;
          }
          else{
            cout<<-1<<endl;return;
          }
          
       }
       else{
         if(a2[j]<=k){
            res.push_back(a2[j]);
            j++;
          }
          else{
            cout<<-1<<endl;return;
          }

       }
     }


   }
    while(i<a){
  if(a1[i]==0){
       res.push_back(0);
       i++;
       k++;
     }
     else{
        if(a1[i]<=k){
            res.push_back(a1[i]);
            i++;
          }
          else{
            cout<<-1<<endl;return;
          }
     }
  
}
 
  while(j<b){
    if(a2[j]==0){
       res.push_back(0);
       j++;
       k++;
     }
     else{
        if(a2[j]<=k){
            res.push_back(a2[j]);
            j++;
          }
          else{
            cout<<-1<<endl;return;
          }
     }



  }

 for(auto i:res) cout<<i<<" ";
 cout<<endl;


}
  
  
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("Input.txt", "r", stdin);
    freopen("Output.txt", "w", stdout);
#endif
   ll t=1;cin>>t;
     while(t--){
       solve();
     }
    return 0;
}