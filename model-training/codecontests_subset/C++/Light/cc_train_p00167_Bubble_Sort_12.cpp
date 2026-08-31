#include<iostream>
#include<vector>

int main(){

	int n;
	while (std::cin >> n, n){
		std::vector<int>size(n);

		for (int i = 0; i < n; i++){
			std::cin >> size[i];
		}

		int cnt=0;
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n-i-1; j++){
				if (size[j]>size[j + 1]){
					cnt++;
					std::swap(size[j], size[j + 1]);
				}
			}
		}
		std::cout << cnt << std::endl;
	}

	return 0;
}