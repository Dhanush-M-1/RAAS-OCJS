#include <iostream>
using namespace std;
int main()
{
  int a[100],n,i,j,t,c;
  for(;;){
    cin >> n;
    if(n==0)break;
    for(i=0;i<n;i++){
      cin >> a[i];
    }
    c = 0;
    for(i=n-1;i>0;i--){
      for(j=0;j<i;j++){
	if(a[j] > a[j+1]){
	  t = a[j];
	  a[j] = a[j+1];
	  a[j+1] = t;
	  c++;
	}
      }
    }
    cout << c << endl;
  }
  return 0;
}