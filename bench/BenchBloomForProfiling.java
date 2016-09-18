/*
   Copyright 2016 Mark Gunlogson

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.TWARE.
*/

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BenchBloomForProfiling {
	public static void main(String[] args) throws Exception {

		for (int j = 0; j < 10000; j++) {

			// create filters
			BloomFilter<Integer> bloom = BloomFilter.create(Funnels.integerFunnel(), 100000, 0.03);
			// benchmark insert
			for (int i = 0; i < 70000; i++) {
				bloom.put(i);
			}
			// benchmark contains(with half true half false expected)
			for (int i = 35000; i < 105000; i++) {
				bloom.mightContain(i);
			}

		}
	}

}