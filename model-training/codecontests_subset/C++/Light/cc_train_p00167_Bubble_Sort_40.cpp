#include<iostream>
#include<utility>
using namespace std;

int main(){
  int n,sort[1111111],cou,tmp;
  while(1){
    cou=0;
    cin >> n;
    if(n == 0) break;
    for(int i=0;i<n;i++){
      cin >> sort[i];
    }
    for(int i=0;i<n;i++){
      for(int j=0;j<n-i-1;j++){
	if(sort[j] > sort[j+1]){
	  swap(sort[j],sort[j+1]);
	  cou++;
	}
      }
    }
    cout << cou << endl;
  }
}