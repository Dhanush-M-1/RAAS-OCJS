#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

int main() {
	string mark = "SHCD";
	int card[4][13];
	for(int i=0;i<4;i++) 
		for(int j=0;j<13;j++)
	    	card[i][j] = 0;
	
	int n;
	cin >> n;
	char c;
	int  x;
	for(int i = 0; i < n; i++) {
		cin >> c >> x;
		card[mark.find(c)][x-1] = 1;
	}

	for(int i=0;i<4;i++) 
		for(int j=0;j<13;j++) {
			if (card[i][j] == 0 ) {
				cout << mark[i] << " " << j+1 << endl;
			}
		}
	return 0;
}


