#include <iostream>
using namespace std;

int main()
{
  int q,n,i,j,max,can;

  cin>>q;
  for(i=0;i<q;i++){
    cin>>n;
    j=0;
    for(;n>9;){
      max=0;
      for(int d=10;n%d!=n;){
	can=(n%d)*(int)((n-(n%d))/d);
	if(can>max) max=can;
	d*=10;
      }
      j++; n=max;
    }
    cout<<j<<endl;
  }
}
