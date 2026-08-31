#include <iostream>
#include <string>
using namespace std;

int main(){

  int len[5] = {5,7,5,7,7};
  int n, i;
  string str[41];
  while(cin >> n, n){
    for(i = 0; i < n; i++){
      cin >> str[i];
    }
    for(i = 0; i < n; i++){
      int sum = 0, idx = 0, flag = 0;
      for(int j = i; j < n; j++){
        sum += str[j].size();
        if(len[idx] == sum){
          sum = 0;
          idx++;
        }else if(len[idx] < sum){
          break;
        }
        if(idx == 5){
          flag = 1;
          break;
        }
      }
      if(flag){
        cout << i + 1 << endl;
        break;
      }
    }
  }
  return 0;
}
