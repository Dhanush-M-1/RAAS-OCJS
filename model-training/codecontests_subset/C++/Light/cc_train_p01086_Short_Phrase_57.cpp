#include<bits/stdc++.h>
using namespace std;

int main(){
  int n;
  while(std::cin >> n, n){
    int length[n];
    string s;
    for (int i = 0; i < n; i++) {
      std::cin >> s;
      length[i] = s.length();
    }
    vector<int> correct = {5, 7, 5, 7, 7};
    for (int i = 0; i < n; i++) {
      int tmp = 0, pos = 0;
      for (int j = i; j < n; j++) {
        tmp += length[j];
        if(tmp == correct[pos])pos++, tmp = 0;
        if(pos == correct.size()){
          std::cout << i + 1 << std::endl;
          i = j = 1e9;
        }
      }
    }
  }
  return 0;
}