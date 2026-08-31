#include <bits/stdc++.h>
using namespace std;
int main() {
  std::string init_str;
  std::getline(std::cin, init_str);
  std::regex re("\[\+|\-]|[0-9]+");
  std::vector<string> sign;
  for (std::sregex_iterator
           it = std::sregex_iterator(init_str.begin(), init_str.end(), re),
           end;
       it != end; ++it) {
    sign.push_back(it->str());
  }
  int res = std::stoi(sign.back());
  sign.pop_back();
  vector<int> isigned, iunsigned;
  if (init_str[0] == '?')
    iunsigned.push_back(1);
  else
    isigned.push_back(1);
  for (string& to : sign) {
    if (to == "-")
      isigned.push_back(1);
    else
      iunsigned.push_back(1);
  }
  int cur_res = iunsigned.size() - isigned.size();
  size_t sig_idx = 0, unsig_idx = 0;
  while (cur_res != res &&
         (unsig_idx < iunsigned.size() || sig_idx < isigned.size())) {
    if (cur_res < res && unsig_idx < iunsigned.size()) {
      while (iunsigned[unsig_idx] < res && cur_res != res) {
        iunsigned[unsig_idx]++;
        cur_res++;
      }
      unsig_idx++;
    } else if (cur_res > res && sig_idx < isigned.size()) {
      while (isigned[sig_idx] < res && cur_res != res) {
        isigned[sig_idx]++;
        cur_res--;
      }
      sig_idx++;
    } else {
      sig_idx++;
      unsig_idx++;
    }
  }
  if (cur_res != res) {
    cout << "Impossible";
    return 0;
  }
  sig_idx = 0;
  unsig_idx = 0;
  cout << "Possible" << endl;
  if (init_str[0] == '?') {
    cout << std::to_string(iunsigned[unsig_idx]);
    unsig_idx++;
  } else {
    cout << "- " + std::to_string(isigned[sig_idx]);
    sig_idx++;
  }
  for (string& to : sign) {
    if (to == "-") {
      cout << " - " << isigned[sig_idx++];
    } else {
      cout << " + " << iunsigned[unsig_idx++];
    }
  }
  cout << " = " << res;
}
