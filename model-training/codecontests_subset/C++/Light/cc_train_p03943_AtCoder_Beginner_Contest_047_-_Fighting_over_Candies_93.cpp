#include <iostream>
using namespace std;
int main(void)
{
  int a,b,c; cin>>a>>b>>c;
  if((a+b==c)||(b+c==a)||(c+a==b))cout<<"Yes"<<endl;
  else cout<<"No"<<endl;

  return 0;
}