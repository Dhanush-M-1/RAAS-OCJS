#include<stdio.h>

int max(int a,int b){
  if(a<b)return b;
  else return a;
}

int Q,A;
int t[1000005];
 
int solve(int id){
  int i;
  int cnt=0;
  while(A>=10){
    if(t[A]==id)return -1;
    t[A]=id;
    
    int x=-1;
    for(i=10;i<A;i*=10){
      int a=A/i,b=A%i;
      x=max(x,a*b);
    }
    A=x;
    cnt++;
  }
  return cnt;
}
 
int main(){ 
  int i;
  scanf("%d",&Q);
  for(i=1;i<=Q;i++){ 
    scanf("%d",&A);
    printf("%d\n",solve(i));
  }
  return 0;
}