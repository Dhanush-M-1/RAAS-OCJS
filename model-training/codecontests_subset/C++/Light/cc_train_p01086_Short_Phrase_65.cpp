#include<bits/stdc++.h>
using namespace std;
int len[] = {5,7,5,7,7};
int main(){
  int n;
  while(cin >> n , n){
    string str[n+1];
    for(int i=0;i<n;i++){
      cin >> str[i];
    }
    for(int i=0;i<n;i++){
      int sum = 0;
      int idx = 0;
      bool flag = false;
      for(int j=i;j<n;j++){
	sum += str[j].size();
	if(len[idx] == sum){
	  sum = 0;
	  idx++;
	} else if(len[idx] < sum) break;
	if(idx == 5){
	  flag = true;
	  break;
	}
      }
      if(flag){
	cout << i+1 << endl;
	break;
      }
    }
  }
}