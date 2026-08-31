#include<iostream>
#include<algorithm>
using namespace std;
int main(){
  int data[100],cnt=0,n,mini;
  cin >> n;
  for(int i=0;i<n;i++) cin >> data[i];
  for(int i=0;i<n;i++){
    mini = i;
    for(int j=i;j<n;j++){
      if(data[j]<data[mini]){
	mini = j;
      }
    }
    if(mini != i){
      cnt++;
      swap(data[i],data[mini]);
    }
  }
  for(int i=0;i<n;i++){
    cout << (i!=0?" ":"") << data[i];
  }
  cout << endl << cnt << endl;
}