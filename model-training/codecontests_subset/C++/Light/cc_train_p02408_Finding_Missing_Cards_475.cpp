#include <iostream>

using namespace std;

bool card[4][14];
char marks[]={'S', 'H', 'C', 'D'};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	int n;
	char mark;
	int num;
	cin>>n;
	for(int i=0; i<n; i++) {
		cin>>mark>>num;
		if     (mark=='S') card[0][num]=true;
		else if(mark=='H') card[1][num]=true;
		else if(mark=='C') card[2][num]=true;
		else if(mark=='D') card[3][num]=true;
	}
	for(int i=0; i<4; i++) {
		for(int j=1; j<=13; j++) {
			if(!card[i][j]) cout<<marks[i]<<' '<<j<<'\n';
		}
	}
	return 0;
}

