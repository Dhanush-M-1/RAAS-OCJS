// 2018/01/05 Tazoe

#include <iostream>
#include <string>
using namespace std;

int main()
{
	while(true){
		int n;
		cin >> n;

		if(n==0)
			break;

		string w[40];
		int len[40];
		for(int i=0; i<n; i++){
			cin >> w[i];
			len[i] = w[i].size();
		}

		for(int i=0; i<n; i++){
			bool flg = false;
			int sta = 0;
			int sum = 0;

			for(int j=i; j<n; j++){
				sum += len[j];

				if(sum==5 || sum==12 || sum==17 || sum==24 || sum==31){
					sta++;
				}

				if(sta==5){
					flg = true;
					break;
				}
				else if(sum>=31){
					break;
				}
			}

			if(flg){
				cout << i+1 << endl;
				break;
			}
		}
	}

	return 0;
}

