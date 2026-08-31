#include<cstdio>
using namespace std;
long gcd(long a, long b){
  if(b==0)
    return a;
  return gcd(b,a%b);
}
int main(){
  int t;
  long a,b,c,d,g;
  scanf("%d",&t);
  for(int i=0;i<t;i++){
    scanf("%ld %ld %ld %ld",&a,&b,&c,&d);
    if(a<b||d<b)
      printf("No\n");
    else if(c>=b)
      printf("Yes\n");
    else{
      g=gcd(b,d);
      if(b-g+(a%g)>c)
        printf("No\n");
      else
        printf("Yes\n");
    }
  }
}