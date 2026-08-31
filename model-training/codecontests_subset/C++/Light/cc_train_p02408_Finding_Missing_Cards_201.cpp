#include<iostream>
#include<vector>
using namespace std;
int main(){
int n,kazu;
char e;
cin>>n;
bool flag[4][13]={0};
for(int i=0;i<n;i++){
cin>>e>>kazu;
if(e=='S')flag[0][kazu-1]=1;
if(e=='H')flag[1][kazu-1]=1;
if(e=='C')flag[2][kazu-1]=1;
if(e=='D')flag[3][kazu-1]=1;
}
for(int i=0;i<4;i++){
for(int j=0;j<13;j++){
if(!(flag[i][j])){
if(i==0)cout<<'S';
if(i==1)cout<<'H';
if(i==2)cout<<'C';
if(i==3)cout<<'D';
cout<<" "<<j+1<<endl;
}
}
}
return 0;
}
