#include <bits/stdc++.h>

std::string next(std::string n) {
  std::string str1;
  std::string str2;
  long max = -1;
  for(int i = 1; i < n.size(); ++i) {
    str1 = str2 = "";
    for(int j = 0; j < i; ++j) {
      str1 += n[j];
    }
    for(int j = i; j < n.size(); ++j) {
      str2 += n[j];
    }
    max = std::max(max, stol(str1) * stol(str2));
  }
  return std::to_string(max);
}                   

int main() {
  int Q;
  std::cin >> Q;
  for(int i = 0; i < Q; ++i) {
    std::string N;
    std::cin >> N;
    int count = 0;
    for(;;) {
      if( N.size() == 1 ) {
        std::cout << count << std::endl;
        break;
      }
      std::string t = next(N);
      N = t;
      count += 1;
    }
  }
  return 0;
}
  