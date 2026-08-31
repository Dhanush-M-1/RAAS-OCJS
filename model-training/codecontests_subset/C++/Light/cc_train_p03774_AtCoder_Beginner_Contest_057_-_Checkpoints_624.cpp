#include <bits/stdc++.h>
using namespace std;

int main(){
int N,M;
cin>>N>>M;
 vector<int>a(N);
 vector<int>b(N);
 vector<int>c(M);
 vector<int>d(M);

 for(int i=0;i<N;i++){
   cin>>a.at(i)>>b.at(i);
 }
 for(int i=0;i<M;i++){
   cin>>c.at(i)>>d.at(i);
 }
 
 for(int i=0;i<N;i++){
   int A=abs(c.at(0)-a.at(i))+abs(d.at(0)-b.at(i));int num=0;
  for(int j=0;j<M;j++){
   int K=abs(c.at(j)-a.at(i))+abs(d.at(j)-b.at(i));
  if(K<A){A=K; num=j;}
 }
 cout<<num+1<<endl;}
      return 0;}