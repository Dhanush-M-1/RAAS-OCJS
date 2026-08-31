#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
#define int long long
bool used[2000000];

int f(int n){

   fill((bool*)used, (bool*)used+2000000, 0);
   used[n]=1;
   int cnt=0;
   while(n>=10){
      string s=to_string(n);
      int nex=0;
      for(int i=1; i<s.size(); i++){

         nex=max<int>(nex, stoll(s.substr(0, i))*stoll(s.substr(i)));
      }
      if(used[nex]) return -1;
      used[nex]=1;
      n=nex; cnt++;
   }

   return cnt;
}

signed main(){

   int Q;
   cin>> Q;
   for(int i=0; i<Q; i++){
      int N;
      cin>> N;
      cout<< f(N)<< endl;
   }
   
   return 0;
}