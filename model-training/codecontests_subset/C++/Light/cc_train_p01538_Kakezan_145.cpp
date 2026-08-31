#include<iostream>
#include<math.h>
using namespace std;

int main(){
  int q;
  int n;
  int count;
  int max;
  cin >> q;
  for(int i=0;i<q;i++){
    cin >> n;
    count=0;
    while(n/10>=1){
      count+=1;
      max=0;
      for(int j=1;j<6;j++){
	int t=pow(10,j);
	int tmp=(n/t)*(n%t);
	if(max<tmp) max=tmp;
      }
      n=max;
    }
    cout<<count<<endl;
  }
  return 0;
}
      