#include <iostream>
#define MAX 10

using namespace std;

int num[MAX];

int bubble_sort(int n){

  int cnt = 0;

  for( int i = 0 ; i < n - 1 ; i++ ){
    for( int j = n - 1 ; j > i ; j-- ){

      if( num[j - 1] > num[j] ){

	int temp = num[j - 1];
	num[j - 1] = num[j];
	num[j] = temp;

	cnt++;

      }
    }
  }
  return cnt;
}


int main(void){

  int n;
  while( cin >> n , n ){

    for( int i = 0 ; i < MAX ; i++ ) num[i] = 0;

    for( int i = 0 ; i < n ; i++ ){
      cin >> num[i];
    }

    cout << bubble_sort(n) << endl;
  }
  return 0;
}