#include <bits/stdc++.h>
using namespace std;

int getRank(char c){
	if(c == 'S') return 0;
	if(c == 'H') return 1;
	if(c == 'C') return 2;
	return 3;
}
int main(){
	int n;
	int cards[4][14] = {};
	char rank[] = {'S', 'H', 'C', 'D'};
	
	cin >> n;
	for(int i=0; i<n; i++){
		char c;
		int r;
		
		cin >> c;
		cin >> r;
		
		cards[getRank(c)][r] = 1;
	}
	for(int i=0; i<4; i++){
		for(int j=1; j<=13; j++){
			if(cards[i][j] == 0){
				cout << rank[i] << " " << j << "\n";
			}
		}
	}
	return 0;
}
