#include <iostream>
using namespace std;

int a[4][13];
char suit;
char s[4] = {'S','H','C','D'};
int N,num;
int main() {
	cin >> N;
	for(int i=0; i<N; ++i) {
		cin >> suit >> num;
		if(suit == 'S') a[0][num] = 1;
		else if(suit == 'H') a[1][num] = 1;
		else if(suit == 'C') a[2][num] = 1;
		else a[3][num] = 1;
	}
	for(int i=0; i<4; ++i) {
		for(int k=0 ; k<13 ; ++k) {
			if(! a[i][k+1]) cout << s[i] << " " << k+1 << endl;
		}
	}
}