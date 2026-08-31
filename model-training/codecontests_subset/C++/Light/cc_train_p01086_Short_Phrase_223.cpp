#include <iostream>
#define rep(i,n) for(int i = 0; i < n; ++i)
using namespace std;

int main(void){
	int n;
	while(cin >> n,n){
		string words[55];
		rep(i,n) cin >> words[i];

		rep(start,n){
			int num = 0,step = 0;
			int tar[5]={5,7,5,7,7};

			for(int j = start; j < n;++j){
				num += words[j].size();
				if(step < 5 and tar[step] == num){
					step++;
					num = 0;
				}
			}

			if(step == 5){
				cout << start+1 << endl;
				break;
			}
		}
	}

	return 0;
}