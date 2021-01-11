class CreateMatrics < ActiveRecord::Migration[6.0]
  def change
    create_table :matrics do |t|
      t.string :like
      t.string :retweet
      t.string :impression
      t.string :new_follower
      t.string :tweet_id

      t.timestamps
    end
  end
end
