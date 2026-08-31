#include<bits/stdc++.h>
using namespace std;
int main(void){
  int a, b, c;
  cin>>a>>b>>c;
  if(max(a,max(b,c))==a+b+c-max(a,max(b,c)))  printf("Yes");
  else  printf("No");
}
