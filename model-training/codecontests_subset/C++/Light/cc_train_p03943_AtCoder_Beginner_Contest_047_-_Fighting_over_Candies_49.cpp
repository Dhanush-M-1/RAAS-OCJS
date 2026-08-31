#include<bits/stdc++.h>
using namespace std;
int main(){
 int a,b,c;scanf("%d%d%d",&a,&b,&c); 
 	int x=max(max(a,b),c);
  if(a+b+c==x+x)puts("Yes");else puts("No");
}