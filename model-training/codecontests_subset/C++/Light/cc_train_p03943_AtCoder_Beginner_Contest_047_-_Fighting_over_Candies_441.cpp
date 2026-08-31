#include <cstdio>

using namespace std;

int main(){
  int a,b,c;

  scanf("%d %d %d",&a,&b,&c);

  if(a+b!=c && b+c!=a && c+a!=b) printf("No");
  else printf("Yes");

  return 0;
}