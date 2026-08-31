#include<iostream>
#include<vector>
using namespace std;

int main(){
  vector<int> num = {5, 7, 5, 7, 7};
  int n;
  while(std::cin >> n, n){
    vector<string> vs(n);
    for (int i = 0; i < n; i++) std::cin >> vs[i];
    for (int i = 0; i < n; i++) {
    int sum = 0, pos = 0;
      for (int j = i; j < n; j++) {
        sum += vs[j].size();
        if(sum == num[pos])sum = 0, pos++;
        if(pos == 5){
          std::cout << i + 1 << std::endl;
          i = j = 1e9;
        }
      }
    }
  }
  return 0;
}