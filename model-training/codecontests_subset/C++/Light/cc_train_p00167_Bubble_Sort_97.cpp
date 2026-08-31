#include<iostream>
#include<vector>

using namespace std;

void BubbleSort(vector<int>);
void swap(int&, int&);

int main(){
  int i, n, x;
  vector<int> data;

  while(1){
    cin >> n;
    if(n == 0) break;

    for(i=0; i<n; i++){
      cin >> x;
      data.push_back(x);
    }

    BubbleSort(data);
    data.clear();
  }

  return 0;
}

void BubbleSort(vector<int> data){
  int i, j, count=0;

  for(i=0; i<data.size(); ++i){
    for(j=0; j<data.size()-i-1; ++j){
      if(data[j] > data[j+1]){
	swap(data[j], data[j+1]);
	++count;
      }
    }
  }

  cout << count << endl;
}

void swap(int& x, int& y){
  int copy;
  copy = x;
  x = y;
  y = copy;
}